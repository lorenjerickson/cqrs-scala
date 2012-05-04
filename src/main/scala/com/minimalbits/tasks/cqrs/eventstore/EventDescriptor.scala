package com.minimalbits.tasks.cqrs.eventstore

import com.minimalbits.tasks.cqrs.event.DomainEvent

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/4/12
 * Time: 1:03 PM
 * To change this template use File | Settings | File Templates.
 */

class EventDescriptor(val id: String, val event: DomainEvent, val version: Int) {

}
