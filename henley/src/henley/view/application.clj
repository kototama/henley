(ns henley.view.application
  (:use clojure.contrib.def
        clojure.contrib.swing-utils
        (henley.view view swingui uicomponents))
  (:import (javax.swing JFileChooser)))

(deftype Application []
  View SwingUI
  (show
   [this]
   ;; (set-look-and-feel2 "Nimbus")
   (do-swing-and-wait
    (.setVisible *frame* true)))
  
  (display-generated-text
   [this text]
   (.setText *generated-text* text))

  (display-statfile
   [this pathname]
   (.setText *input-file* pathname))

  (prompt-file
   [this]
   (let [jc (JFileChooser.)
         val (.showOpenDialog jc *frame*)]
     (when (= val JFileChooser/APPROVE_OPTION)
       (.getSelectedFile jc))))

  
  (add-select-button-listener
   [this f args]
   (apply add-action-listener *select-button* f args))
  
  (add-generate-button-listener
   [this f args]
   (apply add-action-listener *generate-button* f args))
  
  (get-number-of-words
   [this]
   (Integer/parseInt (.getText *nb-words*)))

  (get-statfile
   [this]
   (.getText *input-file*))

  (set-generate-button-enabled
   [this enabled]
   (.setEnabled *generate-button* enabled)))

(defn create-application []
  (Application.))
