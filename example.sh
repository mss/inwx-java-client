#!/bin/bash
set -xe
if [[ ! -e target/inwx-client.jar ]]; then
	mvn package
fi
exec java -cp "target/inwx-client.jar:target/dependency/*" com.inwx.Example example.properties "$@"
