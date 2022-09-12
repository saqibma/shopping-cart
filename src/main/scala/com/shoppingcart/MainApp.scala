package com.shoppingcart

object MainApp extends App {

  val price = new PriceCalculator().calculatePrice(List("Apple", "Apple", "Orange", "Apple"))
  println(price)

  val priceWhenOfferOnApple = new PriceCalculator().calculateOfferPrice(List("Apple", "Apple", "Apple"), "buy one, get one free on Apples")
  println(priceWhenOfferOnApple)

  val priceWhenOfferOnOrange = new PriceCalculator().calculateOfferPrice(List("Orange", "Orange", "Orange"), "3 for the price of 2 on Oranges")
  println(priceWhenOfferOnOrange)
}
