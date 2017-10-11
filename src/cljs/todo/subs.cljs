(ns todo.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]))

;; define handler outside of reg-sub function for testability
(defn todos-subfn
  [db]
  (:todos db))

(re-frame/reg-sub
  :todos
  todos-subfn)

(re-frame/reg-sub
 :name
 (fn [db]
   (:name db)))
