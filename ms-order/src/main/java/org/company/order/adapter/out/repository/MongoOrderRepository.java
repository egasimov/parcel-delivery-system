package org.company.order.adapter.out.repository;

import lombok.RequiredArgsConstructor;
import org.company.order.adapter.out.repository.model.OrderDocument;
import org.company.order.application.out.LoadOrderPort;
import org.company.order.domain.Order;
import org.company.order.domain.OrderStatus;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MongoOrderRepository implements LoadOrderPort {

    private final MongoTemplate mongoTemplate;
    private final String collectionName = "orders";

    @Override
    public Optional<Order> loadByUUID(String orderUUID) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(orderUUID));

        var result = mongoTemplate.findById(orderUUID, OrderDocument.class);

        return Optional.ofNullable(result)
                .map(OrderDocument::toEntity);
    }

    @Override
    public Optional<Order> loadByTrackingRefNo(String trackingRefNo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("trackingRefNo").is(trackingRefNo));

        var result = mongoTemplate.findById(trackingRefNo, OrderDocument.class);

        return Optional.ofNullable(result)
                .map(OrderDocument::toEntity);
    }

    @Override
    public List<Order> loadOrdersOfOrderer(String ordererId, LocalDate from, LocalDate to) {
        var query = new Query(
                Criteria.where("ordererId").is(ordererId)
                        .andOperator(
                                Criteria.where("createdAt").gte(from),
                                Criteria.where("createdAt").lt(to)
                        ));

        List<OrderDocument> result = mongoTemplate.find(query, OrderDocument.class, collectionName);

        return result.stream()
                .map(OrderDocument::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> filterOrdersOfOrdererByStatus(String ordererId, OrderStatus status) {
        var query = new Query(
                Criteria.where("ordererId").is(ordererId)
                        .andOperator(
                                Criteria.where("orderStatus").is(status.name())
                        ));

        List<OrderDocument> result = mongoTemplate.find(query, OrderDocument.class, collectionName);

        return result.stream()
                .map(OrderDocument::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> loadOrdersOfCourier(String courierId, LocalDate from, LocalDate to) {
        var query = new Query(
                Criteria.where("assignedCourierId").is(courierId)
                        .andOperator(
                                Criteria.where("createdAt").gte(from),
                                Criteria.where("createdAt").lt(to)
                        ));

        List<OrderDocument> result = mongoTemplate.find(query, OrderDocument.class, collectionName);

        return result.stream()
                .map(OrderDocument::toEntity)
                .collect(Collectors.toList());
    }

    //testing purpose
    public void save(Order order) {
        mongoTemplate.save(OrderDocument.toDocument(order), "orders");
    }

}
