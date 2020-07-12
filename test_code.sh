#!/bin/bash
status=$(curl -o /dev/null -s -w "{%http_code}" http://192.168.99.101:32033)
if [[ $status==200 ]]
then
python3 /mycode/mail.py
else
python3 /mycode/failed_mail.py
fi
