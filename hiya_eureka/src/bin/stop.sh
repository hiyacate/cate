#!/bin/bash

SERVICE_NAME=hiya_eureka.jar
SERVICE_PORT=8761

PIDS=`jps | grep ${SERVICE_NAME} | grep -v grep | awk '{print $1}'`

if [ -z "$PIDS" ]; then
 echo "No ${SERVICE_NAME} to stop"
 exit 0
else
 kill -s TERM $PIDS
fi

echo -e "Service ${SERVICE_NAME} stoping .\c"
COUNT=1
while [ ${COUNT} -gt 0 ]; do
 for i in `seq 1 360`;
do
echo -e ".\c"
sleep 1
COUNT=`netstat -an | grep ${SERVICE_PORT} | grep LISTEN | grep -v grep | wc -l`
if [ $i -gt 300 ]; then
 echo "\n"
 echo "ERROR: ${SERVICE_NAME} stop [FAILURE]!"
 exit 1
elif [ ${COUNT} -lt 1 ]; then
 echo "\n"
 echo "Service ${SERVICE_NAME} stop sucess!"
 break
fi
done

done
