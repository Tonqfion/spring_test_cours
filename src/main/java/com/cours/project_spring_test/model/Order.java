package com.cours.project_spring_test.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Getter
@Setter
public class Order {

    private Long id;

    private List<OrderProduct> orderProductsList;

    private LocalDate dateCreated;

    private String status;

    private Client client;

    public Order() {
        super();
    }

    public Order(final Long pId, final String pStatus, final LocalDate pDateCreated, final Client pClient) {
        id = pId;
        status = pStatus;
        dateCreated = pDateCreated;
        client = pClient;
    }

    public Double getTotalOrderPrice() {
        return orderProductsList.stream().mapToDouble(OrderProduct::getTotalPrice).sum();
    }

    public int getNumberOfProducts() {
        return orderProductsList.size();
    }

    public int getTotalNumberOfProducts() {
        return orderProductsList.stream().mapToInt(OrderProduct::getQuantity).sum();
    }

    public void addProduct(Product pProduct, int pQuantity) {

        if (orderProductsList == null) {
            orderProductsList = new ArrayList<>();
        }
        final Optional<OrderProduct> optOrderProductPresent = orderProductsList.stream().filter(orderProduct -> orderProduct.getProduct().equals(pProduct)).findFirst();

        if (optOrderProductPresent.isPresent()) {
            final OrderProduct orderProductToUpdate = optOrderProductPresent.get();
            orderProductToUpdate.setQuantity(orderProductToUpdate.getQuantity() + pQuantity);
        } else {
            final OrderProduct newOrderProduct = new OrderProduct(pProduct, this, pQuantity);
            orderProductsList.add(newOrderProduct);
        }


    }

    @Override
    public String toString() {
        return "Le client " + client.getUsername() + " a commandé " + getTotalNumberOfProducts() + " produits pour un total de " + getTotalOrderPrice() + " euros. \n" + orderDetails() + "Status de la commande : " + status;
    }

    public String orderDetails() {
        if (CollectionUtils.isEmpty(orderProductsList)) {
            return "Pas encore de produit dans la commande";
        } else {
            StringBuilder detailsString = new StringBuilder(orderProductsList.get(0).toString());
            if (orderProductsList.size() > 1) {
                for (int i = 1; i < orderProductsList.size(); i++) {
                    detailsString.append(orderProductsList.get(i).toString());
                }
            }
            return detailsString.toString();
        }

    }

}
