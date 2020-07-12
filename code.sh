if kubectl get pods | grep httpd
then
echo "service is running"
else
kubectl create -f /mycode/http-pod.yaml
sleep 20
fi
POD=$(kubectl get pod -l app=httpd -o jsonpath="{.items[0].metadata.name}")
kubectl cp /mycode/*.html $POD:/usr/local/apache2/htdocs/
