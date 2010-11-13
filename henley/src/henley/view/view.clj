(ns henley.view.view)

(defprotocol View
  (show [this])
  (display-statfile [this pathname])
  (display-generated-text [this text]))
