(ns todo.views
  (:require [re-frame.core :as re-frame]
            [reagent.core  :as reagent]))

;; MaterialUI settings and helpers
;(defn color [nme] (aget mui/colors nme))
;(defonce theme-defaults {:muiTheme (mui/getMuiTheme
;                                     (-> mui/darkBaseTheme
;                                         (js->clj :keywordize-keys true)
;                                         (update :palette merge {:primary1Color (color "amber500")
;                                                                 :primary2Color (color "amber700")})
;                                         clj->js))})

(defn add-button []
  (let [input (reagent/atom "")]
    (fn []
      [:div
       [:label {:for "#td-text"} "ToDo: "]
       [:input {:type "text"
                :name "td-text"
                :value @input
                :on-change #(reset! input (-> % .-target .-value))
                :id "td-text"}]
       [:button {:on-click #(re-frame/dispatch [:add-todo {:id "test"
                                                          :description @input
                                                          :done? false}])}]])))

(defn todo-list []
  (let [todos (re-frame/subscribe [:todos])]
    [:ul
     (for [td @todos]
       ^{:key (:id td)}
         [:li (:description td)])]))

(defn header []
  (let [name (re-frame/subscribe [:name])]
    [:div.header {:id "header"}
      [:div (str @name "'s ToDo List")]]))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      ;[mui/MuiThemeProvider theme-defaults]
        [:div {:id "app"}
         [header]
         [todo-list]
         [add-button]])))
