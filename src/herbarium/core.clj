(ns herbarium.core
  (:require [herbarium.database :as db ]
            [ring.adapter.jetty :as jetty]
  )
)

(println (db/get-herbs))

(db/insert-herb "testName" 1 100 0)

(db/update-herb 7 "testNameUpdate" 3 300 1)

(db/delete-herb 8)

(println (db/get-herbs))

(println (db/get-herb 1))

(defn -host
  "Demo host"
  [port-number]
  (jetty/run-jetty
    (fn [request] {:status 200
                   :body "Hello World"
                   :headers {}
                  }
    )
    {:port (Integer. port-number)}
  )
)

(-host 2905)
