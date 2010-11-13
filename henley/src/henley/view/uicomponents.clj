(ns henley.view.uicomponents
  (:use clojure.contrib.def)
  (:import henley.uicomponents.MainFrame))

(defvar *frame* (MainFrame.))
(defvar *generate-button* (.generateButton *frame*))
(defvar *select-button* (.selectButton *frame*))
(defvar *input-file* (.inputFileText *frame*))
(defvar *nb-words* (.numberOfWordsText *frame*))
(defvar *generated-text* (.generatedText *frame*))

