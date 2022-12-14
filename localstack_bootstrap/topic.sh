#!/usr/bin/env bash

set -euo pipefail

echo "configuring sqs"
echo "==================="
LOCALSTACK_HOST=localhost
AWS_REGION=sa-east-1

create_queue() {
    local QUEUE_NAME_TO_CREATE=$1
    awslocal --endpoint-url=http://${LOCALSTACK_HOST}:4566 sqs create-queue --queue-name ${QUEUE_NAME_TO_CREATE} --region ${AWS_REGION} --attributes VisibilityTimeout=30
}

create_topic() {
    local TOPIC_NAME_TO_CREATE=$1
    awslocal --endpoint-url=http://${LOCALSTACK_HOST}:4566 sns create-topic --name ${TOPIC_NAME_TO_CREATE}
    awslocal --endpoint-url=http://${LOCALSTACK_HOST}:4566 sns subscribe --topic-arn="arn:aws:sns:sa-east-1:000000000000:notifica-utilizacao-limite" --protocol=sqs --notification-endpoint=http://localhost:4566/queue/notifica-utilizacao-limite --return-subscription-arn 

}
send_message1() {
    local QUEUE_NAME_TO_CREATE=$1
    awslocal --endpoint-url=http://${LOCALSTACK_HOST}:4566 sqs send-message --queue-url http://${LOCALSTACK_HOST}:4576/queue/${QUEUE_NAME_TO_CREATE} --region ${AWS_REGION} --message-body '{"agencia":"000","numeroConta":"11111","digitoConta":"2","valorMovimento":-100.20}'
}
send_message2() {
    local QUEUE_NAME_TO_CREATE=$1
    awslocal --endpoint-url=http://${LOCALSTACK_HOST}:4566 sqs send-message --queue-url http://${LOCALSTACK_HOST}:4576/queue/${QUEUE_NAME_TO_CREATE} --region ${AWS_REGION} --message-body '{"agencia":"001","numeroConta":"11111","digitoConta":"2","valorMovimento":-100.20}'
}
send_message3() {
    local QUEUE_NAME_TO_CREATE=$1
    awslocal --endpoint-url=http://${LOCALSTACK_HOST}:4566 sqs send-message --queue-url http://${LOCALSTACK_HOST}:4576/queue/${QUEUE_NAME_TO_CREATE} --region ${AWS_REGION} --message-body '{"agencia":"002","numeroConta":"11111","digitoConta":"2","valorMovimento":100.20}'
}
send_message4() {
    local QUEUE_NAME_TO_CREATE=$1
    awslocal --endpoint-url=http://${LOCALSTACK_HOST}:4566 sqs send-message --queue-url http://${LOCALSTACK_HOST}:4576/queue/${QUEUE_NAME_TO_CREATE} --region ${AWS_REGION} --message-body '{"agencia":"003","numeroConta":"11111","digitoConta":"2","valorMovimento":100.20}'
}
create_queue "movimentacoes_conta"
create_topic "notifica-utilizacao-limite"
send_message1 "movimentacoes_conta"
send_message2 "movimentacoes_conta"
send_message3 "movimentacoes_conta"
send_message4 "movimentacoes_conta"