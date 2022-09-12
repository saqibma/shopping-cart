package com.shoppingcart

import org.scalactic.source.Position.here
import org.scalatest.{FunSuite, Matchers}


class PriceCalculatorTest extends FunSuite with Matchers {

  private val priceCalculator = new PriceCalculator()

  test("Buy three Apples and One Orange without offer") {
    // Given that
    val orders = List("Apple","Apple","Orange","Apple")

    // When
    val totalPrice = priceCalculator.calculatePrice(orders)

    // then
    totalPrice should be(2.05)
  }

  test("Buy three Apples with buy one, get one free on Apples") {
    // Given that
    val orders = List("Apple","Apple","Apple")
    val offer = "buy one, get one free on Apples"

    // When
    val totalPrice = priceCalculator.calculateOfferPrice(orders, offer)

    // then
    totalPrice should be(1.2)
  }

  test("Buy three Apples and One Orange with buy one, get one free on Apples") {
    // Given that
    val orders = List("Apple", "Apple", "Orange", "Apple")
    val offer = "buy one, get one free on Apples"

    // When
    val totalPrice = priceCalculator.calculateOfferPrice(orders, offer)

    // then
    totalPrice should be(1.45)
  }

  test("Buy three Oranges with 3 for the price of 2 on Oranges") {
    // Given that
    val orders = List("Orange", "Orange", "Orange")
    val offer = "3 for the price of 2 on Oranges"

    // When
    val totalPrice = priceCalculator.calculateOfferPrice(orders, offer)

    // then
    totalPrice should be(0.5)
  }

  test("Buy One Apple and three Oranges with 3 for the price of 2 on Oranges") {
    // Given that
    val orders = List("Apple", "Orange", "Orange", "Orange")
    val offer = "3 for the price of 2 on Oranges"

    // When
    val totalPrice = priceCalculator.calculateOfferPrice(orders, offer)

    // then
    totalPrice should be(1.1)
  }
}
