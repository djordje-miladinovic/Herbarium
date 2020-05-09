(ns herbarium.database
  (:require [clojure.java.jdbc :as jdbc])
)

(def db-con { :subprotocol "mysql"
              :subname     "//localhost/herbarium"
              :user        "root"
              :password    "root"
            }
)

(defn get-herbs []
  (jdbc/query db-con
             ["SELECT * FROM herbs"]
  )
)