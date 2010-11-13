(ns henley.controller.swing-listeners
  (:use henley.view.swingui
        henley.controller.handlers))

(defn select-button-listener [event view]
  (when-let [file (prompt-file view)]
    (set-generate-button-enabled view true)
    (on-select-statfile view (.getPath file))))

(defn generate-button-listener [event view]
  (when-let [nb-words (get-number-of-words view)]
    (when-let [pathname (get-statfile view)]
      (on-generate-text view pathname nb-words))))
