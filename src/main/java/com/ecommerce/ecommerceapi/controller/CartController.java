//package com.ecommerce.ecommerceapi.controller;
//
//import com.ecommerce.ecommerceapi.entity.Cart;
//import com.ecommerce.ecommerceapi.service.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class CartController {
//
//
//    @Autowired
//    private KeranjangService keranjangService;
//
//    @GetMapping("/keranjangs")
//    public List<Keranjang> findByPenggunaId(@AuthenticationPrincipal UserDetailsImpl user) {
//        return keranjangService.findByPenggunaId(user.getUsername());
//    }
//
//    @PostMapping("/keranjangs")
//    public Keranjang create(@AuthenticationPrincipal UserDetailsImpl user, @RequestBody KeranjangRequest request) {
//        return keranjangService.addKeranjang(user.getUsername(), request.getProdukId(), request.getKuantitas());
//    }
//
//    @PatchMapping("/keranjangs/{produkId}")
//    public Keranjang update(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("produkId") String produkId,
//                            @RequestParam("kuantitas") Double kuantitas) {
//        return keranjangService.updateKuantitas(user.getUsername(), produkId, kuantitas);
//    }
//
//    @DeleteMapping("/keranjangs/{produkId}")
//    public void delete(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("produkId") String produkId) {
//        keranjangService.delete(user.getUsername(), produkId);
//    }
//
//}
