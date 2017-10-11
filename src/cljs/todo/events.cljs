(ns todo.events
  (:require [re-frame.core :as re-frame]
            [todo.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
  :add-todo
  [(re-frame/path :todos)]
  (fn [todos [_ todo]]
    (conj todos todo)))