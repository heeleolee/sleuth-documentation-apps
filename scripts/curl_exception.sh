#!/bin/bash

set -e

echo -e "Sending a request to service1"

SERVICE1_PORT="${SERVICE1_PORT:-8081}"

curl --fail localhost:${SERVICE1_PORT}/readtimeout
