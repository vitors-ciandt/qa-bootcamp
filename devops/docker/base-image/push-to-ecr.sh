#! /usr/bin/env bash

CONTAINER_IMAGE='qa-bootcamp_base-image'
CONTAINER_TAGS=('0.0.1' 'latest')
AWS_DEFAULT_REGION=us-east-1
AWS_ACCOUNT_ID=833104194858

# build docker image
build () {
    docker build \
        -t $CONTAINER_IMAGE:$1 \
        -t $AWS_ACCOUNT_ID.dkr.ecr.$AWS_DEFAULT_REGION.amazonaws.com/$CONTAINER_IMAGE:$1 .
}

# login to ECR and PUSH
push() {
    docker push $AWS_ACCOUNT_ID.dkr.ecr.$AWS_DEFAULT_REGION.amazonaws.com/$CONTAINER_IMAGE:$1
}


aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 833104194858.dkr.ecr.us-east-1.amazonaws.com
for i in "${CONTAINER_TAGS[@]}"
do
    build "$i"
    push "$i"
done