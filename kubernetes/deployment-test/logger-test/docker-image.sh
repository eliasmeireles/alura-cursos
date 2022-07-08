mvn package -DskipTests

minikube image build -t logger-test:1 .

