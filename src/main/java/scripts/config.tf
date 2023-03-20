resource "vault_kubernetes_auth_backend_config" "inv_dev" {
    backend = vault_auth_backend.kubernetes_inv_dev.path
    kubernetes_host = ""
    kubernetes_ca_cert = base64decode(data.vault_kv_secret_v2.inv_dev.data["ca"])
    token_reviewer_jwt = data.vault_kv_secret_v2.data["vault-auth-access-secret"]
}

resource "vault_auth_backend" "example" {
    type = "kubernetes"

    tune {
        max_lease_ttl      = "90000s"
        listing_visibility = "unauth"
    }
}

