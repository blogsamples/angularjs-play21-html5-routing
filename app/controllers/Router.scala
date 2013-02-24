package controllers

import play.api._
import play.api.mvc._

object Router extends Controller {
	def public(route: String) = Action {
		Ok(
			route match {
				case "public1" => views.html.routing.public1()
				case "public2" => views.html.routing.public2()
				case _ => views.html.index() // You could replace that with a 404
			}
		)
	}

	def authenticated(route: String) = Action {
		// Here, you shoud test if the user is correctly authenticated
		val isAuthenticated = true // Replace with a real test

		if (isAuthenticated) {
			Ok(
				route match {
					case "authenticated" => views.html.routing.authenticated()
					case _ => views.html.index() // You could replace that with a 404
				}
			)
		} else {
			Ok(views.html.routing.forbidden()) // Could be a Forbidden
		}
	}

	def admin(route: String) = Action {
		// Here, you shoud test if the user is an admin
		val isAdmin = true // Replace with a real test

		if (isAdmin) {
			Ok(
				route match {
					case "admin1" => views.html.routing.admin1()
					case "admin2" => views.html.routing.admin2()
					case _ => views.html.index() // You could replace that with a 404
				}
			)
		} else {
			Ok(views.html.routing.forbidden()) // Could be a Forbidden
		}
	}
}