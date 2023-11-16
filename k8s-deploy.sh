#!/bin/bash

kubectl apply -f kubernetes/api-gateway-deployment.yaml
kubectl apply -f kubernetes/config-server-deployment.yaml
kubectl apply -f kubernetes/email-service-deployment.yaml
kubectl apply -f kubernetes/service-discovery-deployment.yaml
kubectl apply -f kubernetes/solar-service-deployment.yaml


