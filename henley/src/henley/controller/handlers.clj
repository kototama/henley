(ns henley.controller.handlers
  (:use henley.view.view
        henley.model.text-generator))

(defn on-select-statfile [view pathname]
  (display-statfile view pathname))

(defn on-generate-text [view pathname nb-words]
  (let [stats (read-text pathname)
        generated (generate-text nb-words stats)]
    (display-generated-text view generated)))


