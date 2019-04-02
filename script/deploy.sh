#!/usr/bin/env bash
kill `cat ./application.pid`
nohup java -jar ./relax-user/target/relax-user-0.0.1-SNAPSHOT.jar &