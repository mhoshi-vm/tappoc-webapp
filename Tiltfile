LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')

k8s_custom_deploy(
    'webapp',
    apply_cmd="tanzu apps workload apply -f workload.yaml --live-update" +
                                                        " --local-path . " +
                                                        " --yes >/dev/null" +
                                                        " && kubectl get workload tappoc -o yaml",
                                             delete_cmd="tanzu apps workload delete -f workload.yaml --yes",
                                             container_selector='workload',
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
      sync('./target/classes', '/workspace/BOOT-INF/classes')
    ]
)

k8s_resource('webapp', port_forwards=["8080:8080"],
            extra_pod_selectors=[{'serving.knative.dev/service': 'webapp'}])

allow_k8s_contexts('tap-full')