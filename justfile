# This output
default:
  just --list

# Run Quarkus Dev Mode for PROJECT
dev project:
  ./gradlew {{project}}:quarkusDev

# Real Time Local Dev with coordinated ports (Experimental)
dockerDev:
  echo "This will one day launch services in dev mode"
