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
              ["SELECT * FROM herbs "]
  )
)

(defn get-herb [id]
  (jdbc/query db-con
              ["SELECT * FROM herbs WHERE id = ?" id]
  )
)

(defn insert-herb [n t gh e]
  (jdbc/insert! db-con
                :herbs {:name n
                        :type t
                        :growheight gh
                        :eatable e
                        }
  )
)

(defn update-herb [id n t gh e]
  (jdbc/update! db-con
                :herbs {:name n
                        :type t
                        :growheight gh
                        :eatable e
                        }
                ["id = ?" id]
  )
)

(defn delete-herb [id]
  (jdbc/delete! db-con
                :herbs
                ["id = ?" id]
  )
)