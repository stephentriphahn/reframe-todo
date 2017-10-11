(ns todo.db
  (:require [cljs.spec.alpha  :as s]))

(s/def ::todo-desc string?)
(s/def ::todo-done? boolean?)
(s/def ::todo-priority #{1 2 3 4 5})

(s/def ::todo (s/keys :req [::todo-desc ::todo-done?]
                      :opt [::todo-priority]))

(def default-db
  {:name ""
   :todos []})
