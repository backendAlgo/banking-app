FROM debian:latest

ARG TOKEN=not-set

RUN apt-get update && apt-get install -y curl libgtk-dotnet3.0-cil

ENV RUNNER_ALLOW_RUNASROOT=1

RUN curl -o actions-runner-linux-arm64-2.304.0.tar.gz -L https://github.com/actions/runner/releases/download/v2.304.0/actions-runner-linux-arm64-2.304.0.tar.gz && \
    tar xzf ./actions-runner-linux-arm64-2.304.0.tar.gz
RUN ./config.sh --url https://github.com/backendAlgo/banking-app --token $TOKEN --name linux --work _work --runasservice --disableupdate
CMD ["./run.sh"]