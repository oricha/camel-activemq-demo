Feature: Enviar mensaje a la cola

  Scenario: Enviar mensaje REST a ActiveMQ
    Given un mensaje "Hola, Cucumber!"
    When lo envío al endpoint REST "/api/send"
    Then debería estar en la cola "demo-queue"
