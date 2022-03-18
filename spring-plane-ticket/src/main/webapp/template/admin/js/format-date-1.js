//formatDate: yyyy-MM-dd hh:mm a
function formatDateLocal(date) {
	var d = new Date(date),
		month = '' + (d.getMonth() + 1),
		day = '' + d.getDate(),
		year = d.getFullYear(),
		hours = d.getHours(),
		minutes = d.getMinutes()

	if (month.length < 2) month = '0' + month;
	if (day.length < 2) day = '0' + day;

	// Convert format(dd/MM/yyyy hh:mm a)
	var ampm = hours >= 12 ? 'PM' : 'AM';
	hours = hours % 12;
	hours = hours ? hours : 12; // the hour '0' should be '12'
	minutes = minutes < 10 ? '0' + minutes : minutes;
	var strTime = hours + ':' + minutes + ' ' + ampm;

	return [year, month, day].join('-') + ' ' + strTime;
}
function formatDate(date) {
	var d = new Date(date),
		month = '' + (d.getMonth() + 1),
		day = '' + d.getDate(),
		year = d.getFullYear(),
		hours = d.getHours(),
		minutes = d.getMinutes()

	if (month.length < 2) month = '0' + month;
	if (day.length < 2) day = '0' + day;

	return [year, month, day].join('-') + " " + [hours, minutes].join(':');
}
function dateAdd(date, interval, units) {
	if (!(date instanceof Date))
		return undefined;
	var ret = new Date(date); //don't change original date
	var checkRollover = function() {
		if (ret.getDate() != date.getDate()) ret.setDate(0);
	};
	switch (String(interval).toLowerCase()) {
		case 'year':
			ret.setFullYear(ret.getFullYear() + units);
			checkRollover();
			break;
		case 'quarter':
			ret.setMonth(ret.getMonth() + 3 * units);
			checkRollover();
			break;
		case 'month':
			ret.setMonth(ret.getMonth() + units);
			checkRollover();
			break;
		case 'week':
			ret.setDate(ret.getDate() + 7 * units);
			break;
		case 'day':
			ret.setDate(ret.getDate() + units);
			break;
		case 'hour':
			ret.setTime(ret.getTime() + units * 3600000);
			break;
		case 'minute':
			ret.setTime(ret.getTime() + units * 60000);
			break;
		case 'second':
			ret.setTime(ret.getTime() + units * 1000);
			break;
		default:
			ret = undefined;
			break;
	}
	return ret;
}