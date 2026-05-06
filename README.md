

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

Both implementations support **JSON-based messaging**, showcasing:

* Producer → Broker → Consumer flow
* Manual vs automatic JSON handling
* Real-world event-driven architecture patterns

---

# 🧠 Architecture

## 🔶 ActiveMQ (JMS)

```text id="1l0k3z"
Client → REST → Producer → Queue → Consumer (manual JSON parsing)
```

---

## 🐰 RabbitMQ (AMQP)

```text id="yqds3u"
Client → REST → Producer → Exchange → Queue → Consumer (auto JSON mapping)
```

---

# 📦 Project Structure

```text id="fzn7ub"
spring-boot-queue
│
├── spring-boot-apache-activemq/
│   └── HELP.md   # 📘 Detailed ActiveMQ implementation
│
├── spring-boot-rabbitmq/
│   └── HELP.md   # 📘 Detailed RabbitMQ implementation
│
└── docker-compose.yml
```

---

# 🐳 Running the Project

```bash id="c88fjf"
docker-compose up -d
```

---

## 🌐 Access UI

| Service  | URL                                              | Credentials |
| -------- | ------------------------------------------------ | ----------- |
| ActiveMQ | [http://localhost:8161](http://localhost:8161)   | admin/admin |
| RabbitMQ | [http://localhost:15672](http://localhost:15672) | guest/guest |

---

# 🧪 Messaging Overview

## 🔶 ActiveMQ

* Uses **JMS (Java Message Service)**
* Sends JSON as **String (TextMessage)**
* Consumer manually converts JSON → Object

---

## 🐰 RabbitMQ

* Uses **AMQP protocol**
* Sends **structured JSON object**
* Spring automatically converts JSON → Java object

---

# 🧠 Key Learning

This project highlights an important real-world difference:

| Concept       | ActiveMQ                | RabbitMQ             |
| ------------- | ----------------------- | -------------------- |
| JSON Handling | Manual (`ObjectMapper`) | Automatic            |
| Message Type  | TextMessage             | POJO                 |
| Complexity    | Higher                  | Lower                |
| Use Case      | Legacy / Enterprise     | Modern Microservices |

---

# 📘 Detailed Implementation

👉 For **exact endpoints, request/response, and full implementation details**, refer:

* 📂 `spring-boot-apache-activemq/HELP.md`
* 📂 `spring-boot-rabbitmq/HELP.md`

---

# ⚙️ Key Features

* ✅ Dual messaging systems
* ✅ JSON messaging in both brokers
* ✅ Manual vs automatic serialization comparison
* ✅ REST-based producers
* ✅ Async consumers
* ✅ Dockerized setup

---

# 🧠 Concepts Covered

* JMS vs AMQP
* Producer-Consumer pattern
* Event-driven architecture
* Message serialization strategies
* Queue vs Exchange

---

# ⚠️ Important Notes

* Messages are **consumed once and removed**
* No replay support (unlike Kafka)
* Designed for **async processing systems**

---

# 🚀 Future Enhancements

* Kafka integration
* Dead Letter Queue (DLQ)
* Retry mechanisms
* Observability (OpenTelemetry, Grafana)
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

This project is licensed under the [MIT License](LICENSE).

---

# 🏆 Portfolio Highlight

This project demonstrates:

* Multi-broker messaging expertise
* Real-world JSON messaging patterns
* Understanding of JMS vs AMQP
* Practical event-driven system design

---

# 💡 Pro Insight

> This project doesn’t just show messaging—it demonstrates how different brokers handle JSON differently, which is a key architectural decision in real systems.

---

