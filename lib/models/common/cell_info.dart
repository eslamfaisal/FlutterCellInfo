class BasicCellInfo {
  String title;
  String band;
  String mnc;
  String mcc;
  String iso;
  int bandNumber;
  String bandName;

  BasicCellInfo({
    this.title,
    this.band,
    this.mnc,
    this.mcc,
    this.iso,
    this.bandNumber,
    this.bandName,
  });

  BasicCellInfo.fromJson(Map<String, dynamic> map) {
    this.title = map['title'];
    this.band = map['band'];
    this.mnc = map['mnc'];
    this.mcc = map['mcc'];
    this.iso = map['iso'];
    this.bandNumber = map['bandNumber'];
    this.bandName = map['bandName'];

    Map<String, dynamic> toJson() {
      final Map<String, dynamic> data = new Map<String, dynamic>();
      data['title'] = this.title;
      data['band'] = this.band;
      data['mnc'] = this.mnc;
      data['mcc'] = this.mcc;
      data['iso'] = this.iso;
      data['bandNumber'] = this.bandNumber;
      data['bandName'] = this.bandName;
      return data;
    }
  }
}