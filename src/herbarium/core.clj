(ns herbarium.core
  (:require [herbarium.database :as db ])
)

(println (db/get-herbs))