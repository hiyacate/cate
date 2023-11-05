#!/bin/bash

SERVICE_NAME=demo.jar
SERVICE_PORT=8761
LOGGING_PATH=/home/hiya/log/hiya_demo
JVM_LOG_DIR=/home/hiya/log/hiya_demo/jvm


set -e
DIR=$(cd `dirname $0`; pwd|awk -F':' '{print $1}')
chmod +x $DIR/*.sh
set +e

PIDS=`jps -l | grep ${SERVICE_NAME} | grep -v grep | awk '{print $1}'`

if [ ${PIDS} ];
then
 echo "ERROR: ${SERVICE_name} already started!"
 echo "PID: ${PIDS}"
 exit 1
fi

if [ ! -d "$JVM_LOG_DIR" ]; then
	mkdir -p $JVM_LOG_DIR
fi

nohup java -server -Xmx1G -Xms1G \
 -XX:+UseG1GC \
 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$JVM_LOG_DIR -XX:ErrorFile=$JVM_LOG_DIR/demo_err_pid%p.log \
 -Dhost.name=$HOSTNAME \
 -DAPP_HOME=$DIR \
 -Dlogging.path=${LOGGING_PATH} \
 -jar $DIR/${SERVICE_NAME} "$@" \
 > /dev/null 2>&1 &


echo -e "Starting the ${SERVICE_NAME} .\c"
COUNT=0
while [ ${COUNT} -lt 1 ]; do
for((i=1;i<360;i++));
do
echo -e ".\c"
sleep 1
COUNT=`netstat -an | grep ${SERVICE_PORT} | grep LISTEN |grep -v grep | wc -l`
if [ $i -gt 300 ]; then
 echo ""
 echo "ERROR: Service ${SERVICE_NAME} start [FAILURE]"
 exit 1
elif [ ${COUNT} -gt 0 ]; then
 break
fi
done

done

echo "OK!"

PIDS=`jps -l | grep ${SERVICE_NAME} | grep -v grep | awk '{print $1}'`

echo "PID: ${PIDS}"

if [ ! ${PIDS} ];
then
 echo "ERROR: ${SERVICE_NAME} start [FAILURE]!"
 exit 1
else
 echo "${SERVICE_NAME} start success!"
 exit 0
fi
