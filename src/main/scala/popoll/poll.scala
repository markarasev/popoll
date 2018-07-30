package popoll

import java.util.UUID

import markarasev.utils.{NonEmptySeq, UtcDateTime}

case class DatePoll(
  id: DatePollId,
  title: Title,
  description: Description,
  alternatives: NonEmptySeq[Alternative],
)

case class DatePollId(u: UUID) extends AnyVal

object DatePollId {
  def apply: DatePollId = new DatePollId(UUID.randomUUID())
}

case class Title(u: String) extends AnyVal

case class Description(u: String) extends AnyVal

case class Alternative(date: UtcDateTime, votes: Votes)

case class Votes(ok: Votes.Ok, maybe: Votes.Maybe, ko: Votes.Ko)

object Votes {

  case class Ok(u: Int) extends AnyVal

  case class Maybe(u: Int) extends AnyVal

  case class Ko(u: Int) extends AnyVal

}
