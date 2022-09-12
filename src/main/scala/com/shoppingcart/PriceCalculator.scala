package com.shoppingcart

class PriceCalculator {

  val fruitPrices= Map(
    "Apple" -> 0.60,
    "Orange" -> 0.25
  )

  def calculatePrice(orders: List[String]) : Double =
    orders.map(fruitPrices(_)).fold(0.0) { (totalPrice, orderPrice)  =>
      totalPrice + orderPrice
    }

  def calculateOfferPrice(orders: List[String], offer: String) : Double = {
    val appleCount = orders.count(_ == "Apple")
    val orangeCount = orders.count(_ == "Orange")
    offer match {
      case "buy one, get one free on Apples" =>
        (appleCount - appleCount/2) * fruitPrices("Apple") + orangeCount * fruitPrices("Orange")
      case "3 for the price of 2 on Oranges" =>
        appleCount * fruitPrices("Apple") + (orangeCount - orangeCount/3) * fruitPrices("Orange")
      case _ =>
        appleCount * fruitPrices("Apple") + orangeCount * fruitPrices("Orange")
    }
  }

}
