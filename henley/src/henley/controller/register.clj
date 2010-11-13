(ns henley.controller.register
  (:use henley.view.swingui
        henley.controller.swing-listeners))

(defn register-listeners [swingui]
  (add-select-button-listener swingui select-button-listener [swingui])
  (add-generate-button-listener swingui generate-button-listener [swingui]))