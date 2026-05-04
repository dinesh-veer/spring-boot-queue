
# 🚀 Spring Boot Queue (ActiveMQ + RabbitMQ)

<p align="center">
<b>Messaging Playground using Spring Boot</b><br/>
Apache ActiveMQ (JMS) + RabbitMQ (AMQP) with JSON-based messaging
</p>

<p align="center">
<img src="https://img.shields.io/badge/Java-21%2B-blue?style=for-the-badge&logo=java" />
<img src="https://img.shields.io/badge/Spring%20Boot-4-green?style=for-the-badge&logo=springboot" />
<img src="https://img.shields.io/badge/ActiveMQ-JMS-orange?style=for-the-badge" />
<img src="https://img.shields.io/badge/RabbitMQ-AMQP-ff6600?style=for-the-badge&logo=rabbitmq" />
<img src="https://img.shields.io/badge/JSON-Messaging-blue?style=for-the-badge" />
<img src="https://img.shields.io/badge/Docker-Ready-blue?style=for-the-badge&logo=docker" />
</p>

---

# 📌 Overview

This repository demonstrates **asynchronous messaging using two industry-standard brokers**:

* 🔶 Apache ActiveMQ (JMS)
* 🐰 RabbitMQ (AMQP)

Both implementations support **JSON-based messaging**, but with different approaches:

* ActiveMQ → Manual JSON serialization/deserialization
* RabbitMQ → Automatic JSON conversion

---

# 🧠 Architecture

## 🔶 ActiveMQ (JMS)

```text
Client → REST → Producer → Queue → Consumer (manual JSON parsing)
```

---

## 🐰 RabbitMQ (AMQP)

```text
Client → REST → Producer → Exchange → Queue → Consumer (auto JSON mapping)
```

---

# 📦 Project Structure

```text
spring-boot-queue
│
├── spring-boot-apache-activemq/
│   ├── config/
│   ├── producer/
│   ├── consumer/
│   └── controller/
│
├── spring-boot-rabbitmq/
│   ├── config/
│   ├── producer/
│   ├── consumer/
│   └── controller/
│
└── common/
```

---

# 🐳 Running the Project

```bash
docker-compose up -d
```

---

## 🌐 Access UI

| Service  | URL                                              | Credentials |
| -------- | ------------------------------------------------ | ----------- |
| ActiveMQ | [http://localhost:8161](http://localhost:8161)   | admin/admin |
| RabbitMQ | [http://localhost:15672](http://localhost:15672) | guest/guest |

---

# 🧪 API Endpoints

---

# 🔶 ActiveMQ API (JSON via String)

## 📤 Send Message

```http
POST /producer?message={"orderId":"ORD-101","product":"Laptop","quantity":2}
```

### 🔹 Example

```bash
curl -X POST "http://localhost:8080/producer?message={\"orderId\":\"ORD-101\",\"product\":\"Laptop\",\"quantity\":2}"
```

---

## 📥 Consumer (Manual JSON Parsing)

```java
@JmsListener(destination = "demo.activemqjson")
public void receiveJson(TextMessage message) {
    String json = message.getText();
    OrderMessage order = objectMapper.readValue(json, OrderMessage.class);
    System.out.println("Received Object: " + order);
}
```

---

## 🧾 Output

```text
Produced message: {"orderId":"ORD-101","product":"Laptop","quantity":2}
Received Object: OrderMessage(orderId=ORD-101, product=Laptop, quantity=2)
```

---

# 🐰 RabbitMQ API (JSON via RequestBody)

## 📤 Send Message

```http
POST /producer
Content-Type: application/json
```

---

## 📩 Request Body

```json
{
  "orderId": "ORD-201",
  "product": "Phone",
  "quantity": 1
}
```

---

## 📥 Consumer (Auto Mapping)

```java
@RabbitListener(queues = "your-queue-name")
public void consume(OrderMessage message) {
    System.out.println("Received message: " + message);
}
```

---

## 🧾 Output

```text
Message sent : OrderMessage(orderId=ORD-201, product=Phone, quantity=1)
Received message: OrderMessage(orderId=ORD-201, product=Phone, quantity=1)
```

---

# 🧠 Message Model

```java
class OrderMessage {
    private String orderId;
    private String product;
    private int quantity;
}
```

---

# 🔁 ActiveMQ vs RabbitMQ (Your Implementation)

| Feature          | ActiveMQ                | RabbitMQ      |
| ---------------- | ----------------------- | ------------- |
| Protocol         | JMS                     | AMQP          |
| Input Type       | Query Param             | JSON Body     |
| JSON Handling    | Manual (`ObjectMapper`) | Automatic     |
| Message Type     | TextMessage             | Object        |
| Complexity       | Medium                  | Low           |
| Real-world usage | Legacy / Enterprise     | Microservices |

---

# ⚙️ Key Features

* ✅ Dual messaging systems
* ✅ JSON messaging in both brokers
* ✅ Manual vs automatic serialization comparison
* ✅ REST-based producers
* ✅ Async consumers
* ✅ Docker support

---

# 🧠 Concepts Covered

* JMS vs AMQP
* JSON serialization/deserialization
* Producer-Consumer pattern
* Event-driven architecture
* Message conversion strategies

---

# ⚠️ Important Notes

* ActiveMQ requires **manual JSON parsing**
* RabbitMQ uses **Spring auto conversion**
* Messages are **consumed once**
* No replay support (unlike Kafka)

---

# 🚀 Future Enhancements

* Kafka integration
* Dead Letter Queue (DLQ)
* Retry mechanisms
* OpenTelemetry tracing
* Virtual Threads
* Distributed deployment

---

# 🤝 Contribution

1. Fork the repository
2. Create a branch
3. Commit changes
4. Open a Pull Request

---

# 📬 Contact

**Dinesh Veer**

📧 [dveer123@hotmail.com](mailto:dveer123@hotmail.com)
🔗 [https://github.com/dinesh-veer](https://github.com/dinesh-veer)

---

# ⭐ Support

If this project helped you:

* ⭐ Star the repo
* 🍴 Fork it
* 📢 Share it

---

# 📜 License

MIT License

---

# 🏆 Portfolio Highlight

This project stands out because it demonstrates:

* Two messaging systems side-by-side
* Real-world JSON messaging patterns
* Manual vs automatic serialization strategies
* Practical event-driven architecture

---

# 💡 Pro Insight

> This project doesn’t just show messaging—it shows how **different brokers handle JSON differently**, which is a key real-world design decision.

---

# 🚀 Want to Upgrade This Further?

I can help you add:

* 📊 Architecture diagrams
* 🔥 Kafka module (complete comparison)
* 🧠 Observability (traceId, logs, metrics)
* ⚡ Production-grade retry + DLQ

