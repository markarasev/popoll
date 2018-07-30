package popoll.domain

import popoll.{DatePoll, DatePollId}

import scala.concurrent.Future

trait DatePollRepository {

  def create(datePoll: DatePoll): Future[DatePoll]

  def retrieve(id: DatePollId): Future[Option[DatePoll]]

}
