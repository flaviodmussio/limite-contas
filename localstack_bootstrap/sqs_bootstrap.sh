#!/usr/bin/env bash

set -euo pipefail

echo "configuring sqs"
echo "==================="
LOCALSTACK_HOST=localhost
AWS_REGION=sa-east-1

create_queue() {
    local QUEUE_NAME_TO_CREATE=$1
    awslocal --endpoint-url=http://${LOCALSTACK_HOST}:4576 sqs create-queue --queue-name ${QUEUE_NAME_TO_CREATE} --region ${AWS_REGION} --attributes VisibilityTimeout=30
}
send_message() {
    local QUEUE_NAME_TO_CREATE=$1
    ls
    awslocal --endpoint-url=http://${LOCALSTACK_HOST}:4576 sqs send-message --queue-url http://${LOCALSTACK_HOST}:4576/queue/${QUEUE_NAME_TO_CREATE} --region ${AWS_REGION} --message-body '{"agencia":"002","numero_conta":"11111","digito_conta":"2","valor_movimento":-20.2}'
}
create_queue "movimentacoes_conta"
send_message "movimentacoes_conta"
send_message "movimentacoes_conta"
send_message "movimentacoes_conta"
send_message "movimentacoes_conta"
send_message "movimentacoes_conta"
