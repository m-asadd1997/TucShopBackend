package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.Cart;
import com.example.TucShopBackend.Models.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    @Transactional
    @Modifying
    @Query(value="DELETE FROM product_cart WHERE product_id!=:p_id && cart_id=:c_id", nativeQuery = true)
    public void deleteChildRecordsWhichAreNotUpdated(@Param("p_id") Long pid,@Param("c_id") Long cid);

    @Query(value = "select * from product_cart where cart_id=:id",nativeQuery = true)
    public Set<ProductCart> findAllProductCarts(@Param("id") Long id);
}
