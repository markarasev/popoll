import markarasev.utils.NonEmptySeq

case class Poll(
  title: String,
  questions: NonEmptySeq[Question],
) {

  override def toString: String =
    s"""
      |title: $title
      |
      |$questionsToString
    """.stripMargin

  private def questionsToString =
    questions.toSeq
      .zipWithIndex
      .map {
        case (question, index) => (question, index + 1)
      }
      .map {
        case (question, index) => s"question $index: $question"
      }
      .mkString("\n")

}

case class Question(
  statement: String,
  answer: Answer
) {

  override def toString: String =
    s"""
       |$statement
       |answer:
       |$answer""".stripMargin

}

sealed trait Answer

case object FreeAnswer extends Answer {

  override def toString: String = ""

}

case class MultipleChoiceAnswer(
  choices: NonEmptySeq[String]
) extends Answer {

  override def toString: String =
    choices.toSeq
      .zipWithIndex
      .map {
        case (choice, index) => (choice, index + 1)
      }
      .map {
        case (choice, index) => s"  choice $index: $choice"
      }
      .mkString("\n")

}

Poll(
  "Communication Needs",
  NonEmptySeq(
    Question(
      "What communication channel do you prefer?",
      FreeAnswer
    ),
    Question(
      "Which frequency would you prefer?",
      MultipleChoiceAnswer(
        NonEmptySeq(
          "once a month",
          "quarterly basis",
          "on ad-hoc basis"
        )
      )
    )
  )
)
