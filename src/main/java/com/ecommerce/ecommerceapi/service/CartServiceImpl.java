//package com.ecommerce.ecommerceapi.service;
//
//import com.ecommerce.ecommerceapi.entity.Cart;
//import com.ecommerce.ecommerceapi.exception.BadRequestException;
//import com.ecommerce.ecommerceapi.exception.ResourceNotFoundException;
//import com.ecommerce.ecommerceapi.repository.CartRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import java.util.List;
//
//@Service
//public class CartServiceImpl implements CartService{
//
//    @Autowired
//    private CartRepository cartRepository;
//
//    @Override
//    public List<Cart> findAllCart() {
//        return cartRepository.findAll();
//    }
//
//    @Override
//    public Cart createNewCart(Cart cart) {
//
//        System.out.println("cart : " + cart);
//
//        if (cartRepository.existsById(cart.getCartId())) {
//            throw new BadRequestException("CartId " + cart.getCartId() + " registered");
//        }
//
//        if (!StringUtils.hasText(cart.getCartEmail())) {
//            throw new BadRequestException("Email must filled");
//        }
//
//        if (cartRepository.existsByCartEmail(cart.getCartEmail())) {
//            throw new BadRequestException("Email " + cart.getCartEmail() + " registered");
//        }
//
//
//
//        cart.setIsActive(true);
//        return cartRepository.save(cart);
//    }
//
//    @Override
//    public void deleteCartById(Long cartId) {
//
//    }
//
//    @Override
//    public Cart editCart(Cart cart) {
//        return null;
//    }
//
//    @Override
//    public Cart findCartById(Long cartId) {
//        return cartRepository.findById(cartId)
//                .orElseThrow(() -> new ResourceNotFoundException("Cart not available"));
//    }
//
//
//
//
//
//}
