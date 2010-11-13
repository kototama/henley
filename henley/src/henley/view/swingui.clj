(ns henley.view.swingui)

(defprotocol SwingUI
  (prompt-file [this])
  (add-select-button-listener [this f args])
  (add-generate-button-listener [this f args])
  (get-statfile [this])
  (get-number-of-words [this])
  (set-generate-button-enabled [this enabled]))

