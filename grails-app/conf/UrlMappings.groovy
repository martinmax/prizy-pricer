class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller:'productSurvey',action: 'create')
		"500"(view:'/error')
	}
}
