# Product

<!-- impeccable:product-schema 1 -->

## Platform

web

## Stack

Java 21, Spring Boot, Thymeleaf, and Maven. The browser interface is served by the Java application.

## Users

Primary users are students in a Java and software-patterns workshop who need to understand when and how the Decorator pattern works. Instructors can also use the running example to explain and discuss the implementation.

## Product Purpose

An interactive, working case study that teaches Decorator by composing optional services for temperature-sensitive pharmaceutical shipments. Success means a student can configure a shipment, see the Java-computed quote and service layers, and connect each layer to the pattern's roles.

## Positioning

The selected shipping services are real Java decorators around one shared shipment contract. The interface demonstrates how behavior and cost accumulate through composition, instead of branching into a subclass for every combination.

## Operating Context

Used during a software-patterns workshop in a browser alongside the Java source. Students configure a base shipment and add services such as temperature monitoring, chain-of-custody logging, protective sealing, and insurance, then inspect the resulting quote and decorator chain.

## Capabilities and Constraints

- The Java application computes a shipment quote from a base service wrapped by selected decorators.
- The interface explains the component, concrete component, decorator, concrete decorators, and wrapping order.
- Example rates and delivery windows are synthetic teaching data, labeled as such; they do not represent carrier offers or medical shipping guidance.
- No carrier, payment, tracking, or pharmacy system is connected.

## Evidence on Hand

The provided assignment screenshot requires a real-life Decorator case study and a frontend. No production data, brand assets, or commercial rates were provided.

## Product Principles

- Keep the Java implementation as the source of truth for every quote.
- Show the selected services as an explicit composition chain.
- Make the relationship between each service and its decorator class easy to learn.
- Label illustrative rates and results as synthetic.
